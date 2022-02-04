package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringboot1Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringboot1Application.class,
				args);

		System.out.println("-----------------------------REGISTER OPERATIONS-------------------------");

		UserService service = applicationContext.getBean(UserService.class);
		Register register;
		register = new Register("ZEE00004", "HEMANT", "YADAV", "HEMANT.YADAV@gmail.com", "123456789", null);
		register.setContactnumber(new BigDecimal("8168684339"));
		System.out.println(service.addUser(register));
		
		register = new Register("ZEE00005", "HEMANT01", "YADAV01", "HEMANT.YADAV01@gmail.com", "12345678901", null);
		register.setContactnumber(new BigDecimal("8168685338"));
		System.out.println(service.addUser(register));
		
		register = new Register("ZEE00006", "HEMANT03", "YADAV03", "HEMANT.YADAV03@gmail.com", "12345678903", null);
		register.setContactnumber(new BigDecimal("8168684119"));
		System.out.println(service.addUser(register));

		Optional<Register> register1 = null;

		try {
			register1 = service.getUserById("ZEE00005");
			if (register1 != null) {
				System.out.println("Record found");
				System.out.println(register1.get());
			} else {
				System.out.println("Record is not found");
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidEmailException | InvalidPasswordException
				| InvalidNameException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Register>> optional1;
		try {
			optional1 = service.getAllUserDetails();
			if (optional1.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional1.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service.deleteUserById("ZEE00006");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			for (Register register2 : service.getAllUsers()) {
				if (register2 != null)
					System.out.println(register2);
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) 
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	



	//System.out.println("\n\t\t\t\t\tTHIS IS FOR LOGIN\n");
	
	System.out.println("-----------------------------Subscription OPERATIONS-------------------------");

	
	SubscriptionService service2 = applicationContext.getBean(SubscriptionService.class);
	Subscription subscription;

	
	try {
		subscription = new Subscription("sub009", "2019-04-13", 2599.0f, "credit", "2023-05-03", "active", "annual",
				"false", "ab00021");
		String result= service2.addSubscription(subscription);
		System.out.println(result);
		
		subscription = new Subscription("sub0010", "2017-04-13", 3000.0f, "credit", "2019-05-03", "active", "annual",
				"true", "ab000121");
		String result3 = service2.addSubscription(subscription);
		System.out.println(result3);

		subscription = new Subscription("sub0011", "2016-04-13", 4580.0f, "netbanking", "2017-05-03", "inactive",
				"monthly", "false", "ab000124");
		String result4 = service2.addSubscription(subscription);
		System.out.println(result4);
	} catch (InvalidAmountException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	Optional<Subscription> subscription1 = null;

	try {
		subscription1 = service2.getSubscriptionById("sub009");
		System.out.println(subscription1.get());
	} catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	

	Optional<List<Subscription>> optional;
	try {
		optional = service2.getAllSubscription();
		if (optional.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional.get().forEach(e -> System.out.println(e));
		}
	} catch (InvalidIdLengthException | InvalidAmountException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}

	

	try {
		service2.deleteSubscription("sub009");
	} catch (IdNotFoundException e21) {
		// TODO Auto-generated catch block
		e21.printStackTrace();
	}

	Optional<List<Subscription>> optional8;
	try {
		optional8 = service2.getAllSubscription();
		if (optional8.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional8.get().forEach(e -> System.out.println(e));
		}
	} catch (InvalidIdLengthException | InvalidAmountException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}

	

	System.out.println("\n------------------------MOVIES OPERATIONS------------------------\n");

	MovieService service3 = applicationContext.getBean(MovieService.class);
	Movie movie;

	movie = new Movie("mov009", "matrix", "hrk, srk, atb", 150, "2021-12-19", null, "english", "15", "action");
	String result13 = service3.addMovie(movie);
	System.out.println(result13);

	movie = new Movie("mov0010", "3 idoits", "aamir, kareena, atb", 134, "2021-12-16", null, "hindi", "15",
			"comedy");
	String result5 = service3.addMovie(movie);
	System.out.println(result5);

	movie = new Movie("mov0011", "martian", "xyz, rty, atb", 121, "2016-12-17", null, "english", "12", "sci-fi");
	String result6 = service3.addMovie(movie);
	System.out.println(result6);

	Optional<Movie> movie1 = null;

	try {
		movie1 = service3.getMovieById("mov009");
		System.out.println(movie1.get());
	} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	

	Optional<List<Movie>> optional2;
	try {
		optional2 = service3.getAllMovie();
		if (optional2.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional2.get().forEach(e -> System.out.println(e));
		}
	} catch (NameNotFoundException | InvalidIdLengthException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}

	

	try {
		service3.deleteMovie("mov009");
	} catch (IdNotFoundException e211) {
		// TODO Auto-generated catch block
		e211.printStackTrace();
	}

	Optional<List<Movie>> optional3;
	try {
		optional3 = service3.getAllMovie();
		if (optional3.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional3.get().forEach(e -> System.out.println(e));
		}
	} catch (NameNotFoundException | InvalidIdLengthException e2111) {
		// TODO Auto-generated catch block
		e2111.printStackTrace();
	}

	

	System.out.println("\n------------------------SERIES OPERATIONS------------------------\n");

	SeriesService service4 = applicationContext.getBean(SeriesService.class);
	Series series;

	series = new Series("ser009", "dexter", "joy, ross", "2014-02-25", null, "english", "17", "thriller", 59);
	String result1 = service4.addSeries(series);
	System.out.println(result1);

	series = new Series("ser010", "sunflower", "ret, dfef, deae", "2013-02-25", null, "hindi", "12", "thriller",
			12);
	String result7 = service4.addSeries(series);
	System.out.println(result7);

	series = new Series("ser011", "mirzapur", "joy, ross", "2015-02-25", null, "hindi", "15", "suspense, action",
			32);
	String result8 = service4.addSeries(series);
	System.out.println(result8);

	Optional<Series> series1 = null;

	try {
		series1 = service4.getSeriesById("ser009");
		System.out.println(series1.get());
	} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e200) {
		// TODO Auto-generated catch block
		e200.printStackTrace();
	}
	

	Optional<List<Series>> optional4;
	try {
		optional4 = service4.getAllSeries();
		if (optional4.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional4.get().forEach(e -> System.out.println(e));
		}
	} catch (NameNotFoundException | InvalidIdLengthException e2000) {
		// TODO Auto-generated catch block
		e2000.printStackTrace();
	}

	

	try {
		service4.deleteSeries("ser009");
	} catch (IdNotFoundException e20000) {
		// TODO Auto-generated catch block
		e20000.printStackTrace();
	}

	Optional<List<Series>> optional5;
	try {
		optional5 = service4.getAllSeries();
		if (optional5.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional5.get().forEach(e -> System.out.println(e));
		}

	} catch (NameNotFoundException | InvalidIdLengthException e2100) {
		// TODO Auto-generated catch block
		e2100.printStackTrace();
	}

	
	System.out.println("\\n------------------------Episodes OPERATIONS------------------------\\n");

	EpisodeService service5 = applicationContext.getBean(EpisodeService.class);
	Episodes episodes;

	episodes = new Episodes("epi001", "black1", 35, "ser010");
	String result9 = service5.addEpisode(episodes);
	System.out.println(result9);

	episodes = new Episodes("epi002", "black2", 27, "ser010");
	String result10 = service5.addEpisode(episodes);
	System.out.println(result10);

	episodes = new Episodes("epi003", "black3", 31, "ser010");
	String result11 = service5.addEpisode(episodes);
	System.out.println(result11);

	episodes = new Episodes("epi004", "red12", 38, "ser011");
	String result12 = service5.addEpisode(episodes);
	System.out.println(result12);

	episodes = new Episodes("epi005", "red13", 45, "ser011");
	String result15 = service5.addEpisode(episodes);
	System.out.println(result15);

	episodes = new Episodes("epi006", "violet1", 23, "ser013");
	String result14 = service5.addEpisode(episodes);
	System.out.println(result14);

	Optional<Episodes> episodes1 = null;

	try {
		episodes1 = service5.getEpisodeById("epi003");
		System.out.println(episodes1.get());
	} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e1100) {
		// TODO Auto-generated catch block
		e1100.printStackTrace();
	}
	

	Optional<List<Episodes>> optional6;
	try {
		optional6 = service5.getAllEpisode();
		if (optional6.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional6.get().forEach(e -> System.out.println(e));
		}
	} catch (InvalidIdLengthException e1120) {
		// TODO Auto-generated catch block
		e1120.printStackTrace();
	}

	

	try {
		service5.deleteEpisode("epi003");
	} catch (IdNotFoundException e11) {
		// TODO Auto-generated catch block
		e11.printStackTrace();
	}

	Optional<List<Episodes>> optional7;
	try {
		optional7 = service5.getAllEpisode();
		if (optional7.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional7.get().forEach(e -> System.out.println(e));
		}

	} catch (InvalidIdLengthException e13) {
		// TODO Auto-generated catch block
		e13.printStackTrace();
	}

	
	applicationContext.close();

}

}
	
	
	
	