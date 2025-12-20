package FileManager;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
public class AppTest {

    @Test
    void testHello(CapturedOutput capture) throws Exception {
        App.main(new String[]{});
        assertThat(capture.toString()).isEqualToIgnoringNewLines(">>> Hello World!");
    }
}
