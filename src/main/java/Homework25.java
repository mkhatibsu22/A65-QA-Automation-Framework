public class Homework25 {
    ChromeOptions browserOptions = new ChromeOptions();
browserOptions.setPlatformName("Windows 10");
browserOptions.setBrowserVersion("131");
    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
ltOptions.put("username", "mkhatibsu22");
ltOptions.put("accessKey", "OUzjDicFstAqZq1NCnNCQYzTkmbHVLpQA0l9z5drlad7ZROmYa");
ltOptions.put("project", "Untitled");
ltOptions.put("selenium_version", "4.0.0");
ltOptions.put("w3c", true);
browserOptions.setCapability("LT:Options", ltOptions);
}
