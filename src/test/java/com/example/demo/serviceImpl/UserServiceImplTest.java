/*
 * package com.example.demo.serviceImpl;
 * 
 * import static org.junit.jupiter.api.Assertions.*; import static
 * org.mockito.Mockito.when; import org.junit.jupiter.api.Test; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.Mockito;
 * import com.example.demo.Mapper.UserMapper; import
 * com.example.demo.dto.UserDto; import com.example.demo.model.User; import
 * com.example.demo.repository.UserRepo; import
 * com.example.demo.services.UserService;
 * 
 * class UserServiceImplTest {
 * 
 * @Mock private UserRepo userRepo;
 * 
 * @InjectMocks private UserService userService;
 * 
 * @Test void testCreateAdmin() { UserDto userDto = new UserDto("u001",
 * "Ashu001", "ashutosh", "TIgga", "male", "ashu@gmail.com", "Ashu@123", "SDE",
 * "8675668", null); User user = UserMapper.mapToUser(userDto);
 * when(userRepo.save(Mockito.any(User.class))).thenReturn(user); UserDto
 * userDto1 = userService.createAdmin(userDto); assertEquals(userDto1, userDto);
 * }
 * 
 * }
 */