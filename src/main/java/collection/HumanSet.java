package collection;

import builders.HumanDirector;
import cmd.MainCollectible;
import exceptions.ValidException;
import humans.HumanBeing;
import humans.Mood;
import humans.WeaponType;
import io.XMLFileWriter;
import utils.FileChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

public class HumanSet {
    private final Set<HumanBeing> collection;
    private final HumanDirector humanDirector;
    private final LocalDateTime creationDate;
    private final Validator<HumanBeing> validator;
    private final XMLFileWriter<HumanBeing> writer;
    private final File file;

    public HumanSet(Collection<HumanBeing> collection, HumanDirector humanDirector, File file, Validator<HumanBeing> validator, XMLFileWriter<HumanBeing> writer) {
        this.humanDirector = humanDirector;
        this.writer = writer;
        this.collection = new LinkedHashSet<>();
        this.validator = validator;
        collection.forEach(this::add);
        this.file = file;
        this.creationDate = LocalDateTime.now();
        System.out.println("Collection was initialized");
    }

    public Set<HumanBeing> getCollection() {
        return collection;
    }

    public String add(HumanBeing element) {
        try {
            String message;
            if (validator.checkElement(element) && !checkElementById(element.getId())) {
                collection.add(element);
                message = String.format("HumanBeing with id: %s was added to collection", element.getId().toString());
            } else {
                message = String.format("element: %s is already exists", element.getId().toString());
            }
            return message;
        } catch (ValidException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String addIfMin(HumanBeing humanBeing) {
        if (collection.size() == 0) {
            return add(humanBeing);
        }
        if (getMinElement().get().compareTo(humanBeing) > 0) {
            return add(humanBeing);
        } else {
            return "Human more than min of collection or equals it";
        }
    }

    public boolean checkElementById(UUID id) {
        return collection.stream()
                .map(HumanBeing::getId)
                .anyMatch(uuid -> uuid.equals(id));
    }

    public Optional<HumanBeing> getMinElement() {
        return collection.stream().min(Comparator.comparingLong(HumanBeing::getImpactSpeed));
    }

    public void clear() {
        collection.clear();
    }

    public void exit() {
        System.out.println("Bye!");
        System.exit(0);
    }

    public HumanDirector getHumanDirector() {
        return humanDirector;
    }

    public void removeById(String uuid) {
        if (uuid.equals("")) {
            System.out.println("Не ввели аргумент");
        }
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getId() == UUID.fromString(uuid)) {
                collection.remove(humanBeing);
                System.out.println("element #" + uuid + "successfully updated");
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (MainCollectible human : collection) {
            str.append(human.toString()).append("\n");
        }
        return str.toString();
    }

    public void removeLower(HumanBeing humanBeing) {
        collection.removeIf(humanBeing1 -> humanBeing1.compareTo(humanBeing) < 0);
    }

    public int countLessWeapon(String arg) {
        WeaponType weaponType = WeaponType.valueOf(arg);
        int res = 0;
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getWeaponType().getNumber() - weaponType.getNumber() < 0) {
                res++;
            }
        }
        return res;
    }

    public String filterByImpactSpeed(String arg) {
        int speed = Integer.parseInt(arg);
        StringBuilder str = new StringBuilder();
        for (MainCollectible human : collection) {
            if (speed == human.getImpactSpeed()) {
                str.append(human).append("\n");
            }
        }
        return str.toString();
    }

    public String filterGreaterThanMood(String arg) {
        Mood mood = Mood.valueOf(arg);
        StringBuilder str = new StringBuilder();
        for (MainCollectible human : collection) {
            Mood collectionMood = human.getMood();
            if (collectionMood != null && collectionMood.getNumber() - mood.getNumber() > 0) {
                str.append(human).append("\n");
            }
        }
        return str.toString();
    }

    public void save(String[] arg) throws FileNotFoundException {
        if (arg.length == 0) {
            writer.writeCollectionToFile(file, collection);
        } else {
            File newFile = new File(arg[0]);
            if (FileChecker.checkFileToWrite(newFile)) {
                writer.writeCollectionToFile(newFile, collection);
            } else {
                throw new FileNotFoundException(String.format("With name - %s", arg[0]));
            }
        }
    }
}
