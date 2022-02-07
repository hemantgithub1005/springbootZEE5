package com.zee.zee5app;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tomcat.util.http.fileupload.FileUtils;
//
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.Utils.Fileutils;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movie;
//
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.UserService;
//
public class Main2 {

	
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringboot1Application.class,
				args);
		
		MovieService movieService=applicationContext.getBean(MovieService.class);
		
		Movie movie;
		movie=new Movie("mov001","18","alluarjun",12,"250","pushpa","abc",null, null);
	    
		
		
		
		
		
//		FileInputStream fileInputStream =null;
		
//		try {
//		fileInputStream=new FileInputStream("C:\\pushpa");
//		long fileSize=new File("C:\\pushpa").length();
//		byte[] allBytes=new byte[(int) fileSize];
//		
//		try {
//			fileInputStream.read(allBytes);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		movie.setTrailer(allBytes);
//		
//		movieService.addMovie(movie);
//		movie.setReleaseDate("2022-10-10");
//		}
//		catch(FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				fileInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		
		
		
//		Role role=new Role();
//		
//		role.setRoleName(EROLE.ROLE_ADMIN);
//		
//		Role role2=new Role();
//		
//		role.setRoleName(EROLE.ROLE_USER);
//		
//		RoleService roleService=applicationContext.getBean(RoleService.class);
//		
//		RoleRepository roleRepository=applicationContext.getBean(RoleRepository.class);
//		
//		System.out.println(roleService.addRole(role));
//		
//		
//
//		UserService service =applicationContext.getBean(UserService.class);
//		Register register;
////		
//		
//	register = new Register("ZEE0000789911", "HEMANT011134", "YADAV011134", "HEMANT241111.YADAV03@gmail.com", "123456178903", null, null);
//	register.setContactNumber(new BigDecimal("8168683610"));
//		
//		
////		SeriesService service4 = applicationContext.getBean(SeriesService.class);
////		Series series;
////		series = new Series("ser009", "dexter", "joy, ross", "2014-02-25", null, "english", "17", "thriller",23,null);
////		String result1 = service4.addSeries(series);
//		
//		
//	
////	    EpisodeService service3 =applicationContext.getBean(EpisodeService.class);
////		Episodes episodes33;
////		
////		episodes33=new Episodes("EP0001","EPISODE1",155,null);
////		System.out.println(service3.addEpisode(episodes33));
//		
//
//		Set<Role>roles=new HashSet<>();
//		
//		roles.add(roleRepository.findById(1).get());
//		roles.add(roleRepository.findById(2).get());
//		
//		
//		register.setRoles(roles);
//		
//	    try {
//			System.out.println(service.addUser(register));
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
//		UserRepository repository =applicationContext.getBean(UserRepository.class);
//		MovieRepository repository2 =applicationContext.getBean(MovieRepository.class);
//		
//		
//		System.out.println(repository.existsByEmailAndContactNumber("HEMANT.YADAV@gmail.com",new BigDecimal("8168684339")));
//		
//		MovieRepository movierepository =applicationContext.getBean(MovieRepository.class);
//		System.out.println(movierepository.findByMovieNameAndReleaseDate("ddlj", "2022-10-12"));
//	applicationContext.close();
	}
//	
}