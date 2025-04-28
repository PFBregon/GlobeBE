package dev.patriciafb.spring.academy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AcademyServiceTest {
    private final AcademyRepository repository = Mockito.mock(AcademyRepository.class);
    private final AcademyService service = new AcademyService(repository);

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        service.deleteById(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void testFindAll() {
        List<Academy> academies = List.of(new Academy(), new Academy());
        when(repository.findAll()).thenReturn(academies);

        List<Academy> result = service.findAll();

        assertEquals(academies, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Academy academy = new Academy();
        when(repository.save(academy)).thenReturn(academy);

        Academy result = service.save(academy);

        assertEquals(academy, result);
        verify(repository, times(1)).save(academy);
    }
}
