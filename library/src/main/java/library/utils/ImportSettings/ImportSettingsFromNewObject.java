package library.utils.ImportSettings;

public class ImportSettingsFromNewObject implements ImportSettings {
    public Object getObjectSettings(Class clazz) throws Exception {
        return clazz.newInstance();
    }
}
