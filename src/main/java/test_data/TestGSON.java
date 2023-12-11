package test_data;

import com.google.gson.Gson;

public class TestGSON {

    public static void main(String[] args) {
//        testGsonSample();
//        testBuilderMethod();
        testDataArray();
    }

    private static void testDataArray() {
        String relativeDataFileLocation = "/src/main/java/test_data/data.json";
        ComputerData[] computerDatas = DataObjectBuilder.builDataObjectFrom(relativeDataFileLocation, ComputerData[].class);
        for (ComputerData computerData : computerDatas) {
            System.out.println(computerData);
            System.out.println(computerData.getProcessor());
        }
    }

    private static void testBuilderMethod() {
        String relativeDataFileLocation = "/src/main/java/test_data/data.json";
        ComputerData computerData = DataObjectBuilder.builDataObjectFrom(relativeDataFileLocation, ComputerData.class);
        System.out.println(computerData);
        System.out.println(computerData.getProcessor());
    }

    private static void testGsonSample() {
        String JSONString = "{\n" +
                "  \"processor\": \"2.5GHz\",\n" +
                "  \"ram\": \"4GB\",\n" +
                "  \"os\": \"MacOS\",\n" +
                "  \"hdd\": \"512GB\",\n" +
                "  \"software\": \"Photoshop\"\n" +
                "}";

        Gson gson = new Gson();

        // From json string to object
        ComputerData computerData = gson.fromJson(JSONString, ComputerData.class);
        System.out.println(computerData);

        // From object to json string
        System.out.println(gson.toJson(computerData));
    }
}
