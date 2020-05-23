package test.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetTestData {
    Properties properties;

    /**
     * This method used to extract the test data from the properties file
     * "HerokuappTestData.properties" & "GoogleTestData.properties" Properties
     * files.
     * 
     * @param properties object of Properties class to load and access properties
     *                   file to externalize test data.
     * @param dataQuery  test data name in test data file.
     * @param fileName   test data file name need to access.
     * @return the test data value from the file.
     */
    public String getTestData(String fileName, String dataQuery) {
	properties = new Properties();

	try {
	    properties.load(new FileInputStream("src/test/resources/TestDataFiles/" + fileName));
	} catch (IOException e) {
	    e.printStackTrace();
	}

	return properties.getProperty(dataQuery);
    }

}
