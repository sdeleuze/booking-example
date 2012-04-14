package org.resthub.booking.repository.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.booking.model.Hotel;
import org.resthub.booking.model.User;
import org.resthub.booking.repository.HotelRepository;
import org.resthub.booking.repository.UserRepository;
import org.resthub.common.util.PostInitialize;

/**
 * Initialize datas
 */
@Named("bookingInitializer")
public class BookingInitializer {

	@Inject
	@Named("hotelRepository")
	protected HotelRepository hotelRepository;

	@Inject
	@Named("userRepository")
	protected UserRepository userRepository;

	@PostInitialize
	public void init() {
		User u = new User("Demo Demo", "demo", "demo@example.com", "demo");
		userRepository.save(u);
		u = new User("Dan Allen", "dan", "dan@example.com", "laurel");
		userRepository.save(u);
		u = new User("Pete Muir", "pete", "pete@example.com", "edinburgh");
		userRepository.save(u);
		u = new User("Lincoln Baxter III", "lincoln", "lincoln@example.com", "charlotte");
		userRepository.save(u);
		u = new User("Shane Bryzak", "shane", "shane@example.com", "brisbane");
		userRepository.save(u);
		u = new User("Gavin King", "gavin", "gavin@example.com", "mexico");
		userRepository.save(u);

		Hotel h = new Hotel(129, 3, "Marriott Courtyard", "Tower Place, Buckhead", "Atlanta", "GA", "30305", "USA");
		hotelRepository.save(h);
		h = new Hotel(84, 4, "Doubletree Atlanta-Buckhead", "3342 Peachtree Road NE", "Atlanta", "GA", "30326", "USA");
		hotelRepository.save(h);
		h = new Hotel(289, 4, "W New York - Union Square", "201 Park Avenue South", "New York", "NY", "10003", "USA");
		hotelRepository.save(h);
		h = new Hotel(219, 3, "W New York", "541 Lexington Avenue", "New York", "NY", "10022", "USA");
		hotelRepository.save(h);
		h = new Hotel(250, 3, "Hotel Rouge", "1315 16th Street NW", "Washington", "DC", "20036", "USA");
		hotelRepository.save(h);
		h = new Hotel(159, 4, "70 Park Avenue Hotel", "70 Park Avenue, 38th St", "New York", "NY", "10016", "USA");
		hotelRepository.save(h);
		h = new Hotel(198, 4, "Parc 55", "55 Cyril Magnin Street", "San Francisco", "CA", "94102", "USA");
		hotelRepository.save(h);
		h = new Hotel(189, 4, "Conrad Miami", "1395 Brickell Ave", "Miami", "FL", "33131", "USA");
		hotelRepository.save(h);
		h = new Hotel(111, 4, "Grand Hyatt", "345 Stockton Street", "San Francisco", "CA", "94108", "USA");
		hotelRepository.save(h);
		h = new Hotel(54, 1, "Super 8 Eau Claire Campus Area", "1151 W MacArthur Ave", "Eau Claire", "WI", "54701", "USA");
		hotelRepository.save(h);
		h = new Hotel(199, 4, "San Francisco Marriott", "55 Fourth Street", "San Francisco", "CA", "94103", "USA");
		hotelRepository.save(h);
		h = new Hotel(543, 4, "Hilton Diagonal Mar", "Passeig del Taulat 262-264", "Barcelona", "Catalunya", "08019", "ES");
		hotelRepository.save(h);
		h = new Hotel(335, 5, "Hilton Tel Aviv", "Independence Park", "Tel Aviv", null, "63405", "IL");
		hotelRepository.save(h);
		h = new Hotel(242, 5, "InterContinental Hotel Tokyo Bay", "1-15-2 Kaigan", "Tokyo", "Minato", "105", "JP");
		hotelRepository.save(h);
		h = new Hotel(130, 4, "Hotel Beaulac", " Esplanade LŽopold-Robert 2", "Neuchatel", null, "2000", "CH");
		hotelRepository.save(h);
		h = new Hotel(266, 5, "Conrad Treasury Place", "130 William Street", "Brisbane", "QL", "4001", "AU");
		hotelRepository.save(h);
		h = new Hotel(170, 4, "Ritz-Carlton Montreal", "1228 Sherbrooke St West", "Montreal", "Quebec", "H3G1H6", "CA");
		hotelRepository.save(h);
		h = new Hotel(179, 4, "Ritz-Carlton Atlanta", "181 Peachtree St NE", "Atlanta", "GA", "30303", "USA");
		hotelRepository.save(h);
		h = new Hotel(145, 4, "Swissotel Sydney", "68 Market Street", "Sydney", "NSW", "2000", "AU");
		hotelRepository.save(h);
		h = new Hotel(178, 4, "Meli‡ White House", "Albany Street Regents Park", "London", null, "NW13UP", "GB");
		hotelRepository.save(h);
		h = new Hotel(159, 3, "Hotel Allegro", "171 W Randolph Street", "Chicago", "IL", "60601", "USA");
		hotelRepository.save(h);
		h = new Hotel(296, 5, "Caesars Palace", "3570 Las Vegas Blvd S", "Las Vegas", "NV", "89109", "USA");
		hotelRepository.save(h);
		h = new Hotel(300, 4, "Mandalay Bay Resort & Casino", "3950 Las Vegas Blvd S", "Las Vegas", "NV", "89119", "USA");
		hotelRepository.save(h);
		h = new Hotel(100, 2, "Hotel Cammerpoorte", "Nationalestraat 38-40", "Antwerp", null, "2000", "BE");
		hotelRepository.save(h);
	}
}
