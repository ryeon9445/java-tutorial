package com.cbr.java.lambda;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final List<String> FRIENDS = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    public static final List<String> EDITORS = Arrays.asList("Brian", "Jackie", "John", "Mike");
    public static final List<String> COMRADES = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

    public static final List<Person> PEOPLE = Arrays.asList(
            new Person("Greg", 35),
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21));

    public static final List<Asset> ASSETS = Arrays.asList(
            new Asset(Asset.AssetType.BOND, 1000),
            new Asset(Asset.AssetType.BOND, 2000),
            new Asset(Asset.AssetType.STOCK, 3000),
            new Asset(Asset.AssetType.STOCK, 4000)
    );
}