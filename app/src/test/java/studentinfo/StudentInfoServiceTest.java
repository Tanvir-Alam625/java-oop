package studentinfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentInfoServiceTest {

    @Test
    void shouldReturnFoundResultWhenIdAndNameMatch() {
        StudentInfoService service = new StudentInfoService();

        String result = service.getResultByIdAndName(1, "Ali");

        assertTrue(result.contains("Found student"));
    }

    @Test
    void shouldReturnNotFoundWhenNoMatch() {
        StudentInfoService service = new StudentInfoService();

        String result = service.getResultByIdAndName(10, "Unknown");

        assertTrue(result.contains("No student found"));
    }
}