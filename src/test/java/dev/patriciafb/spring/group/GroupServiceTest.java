package dev.patriciafb.spring.group;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroupServiceTest {
    private final GroupRepository repository = Mockito.mock(GroupRepository.class);
    private final GroupService service = new GroupService(repository);

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        service.deleteById(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void testFindAll() {
        List<Group> groups = Arrays.asList(new Group(), new Group());
        when(repository.findAll()).thenReturn(groups);

        List<Group> result = service.findAll();

        assertEquals(groups, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Group group = new Group();
        when(repository.save(group)).thenReturn(group);

        Group result = service.save(group);

        assertEquals(group, result);
        verify(repository, times(1)).save(group);
    }
}
