import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;

@Slf4j
public class OrcleTest {
    @Test
    void test1() throws FileNotFoundException {
        File file = new File("C:\\Users\\qsw233\\Desktop\\oracle.sql");
        FileReader fileReader = new FileReader(file);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while(line != null){

//                log.info("result : {}", line);
                fileWriter(line.replaceAll("SAUP", ""));
                line = reader.readLine();
            }
        } catch (Exception e) {
            log.info("error", e);
        }
    }
    private void fileWriter(String line) throws IOException {
        File file = new File("C:\\Users\\qsw233\\Desktop\\oracle_after.sql");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(line);
    }

    @Test
    void test2() throws FileNotFoundException {

        File file = new File("C:\\Users\\qsw233\\Desktop\\oracle_after.sql");
        FileReader fileReader = new FileReader(file);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while(line != null){

                log.info("result : {}", line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            log.info("error", e);
        }

    }
}
