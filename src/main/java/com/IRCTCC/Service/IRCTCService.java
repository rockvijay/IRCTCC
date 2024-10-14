package com.IRCTCC.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IRCTCC.Pojo.Book;
import com.IRCTCC.Pojo.Train;
import com.IRCTCC.Repository.BookingRepository;
import com.IRCTCC.Repository.GetPnrRepository;
import com.IRCTCC.Repository.TrainRepository;

@Service
public class IRCTCService {

    @Autowired
    private TrainRepository trainRepository;
    
    @Autowired
    BookingRepository bookingRepository;
    
    @Autowired
    GetPnrRepository getPnrRepository;

    public List<Train> findTrainsByRoute(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }
    
    public void saveAllPassengers(List<Book> passengers) {
    	
    	bookingRepository.saveAll(passengers);
    }
    
    public Train findTrainById(Long trainId) {
   	 
        return trainRepository.findById(trainId).orElse(null);
    }
    
    public String generatePNR() {
    	
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase(); 
    }
    
    public void saveTrain(Train train)
    {
    	trainRepository.save(train);
    }
    
    public String getPnrByBookingId(String bookingId) {
        // Fetch PNR from the repository
        Book booking = getPnrRepository.findByBookingId(bookingId);

        // Check if PNR exists
        if (booking!=null) {
            return booking.getPnr();  // Return the PNR if found
        } else {
            // If no PNR is found for the bookingId, return null
            return null;
        }
    }

}
