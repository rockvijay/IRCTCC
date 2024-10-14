package com.IRCTCC.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.IRCTCC.Pojo.Book;
import com.IRCTCC.Pojo.Train;
import com.IRCTCC.Service.IRCTCService;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@Controller
@RequestMapping("/irctc")
public class IRCTCController {

    @Autowired
    private IRCTCService irctcService;
    
    @GetMapping("/login")
    public String getLoginPage()
    {
    	return "loginPage";
    	
    }
    
    @GetMapping("/getPnr/{bookingId}")
    public ResponseEntity<String> getPnrByBookingId(@PathVariable("bookingId") String bookingId) {
        System.out.println(bookingId);
    	String pnr = irctcService.getPnrByBookingId(bookingId);
        if (pnr != null) {
            return ResponseEntity.ok(pnr);  // Return the PNR
        } else {
            return ResponseEntity.status(404).body("PNR not found for booking ID: " + bookingId);
        }
    }
    
    
    @GetMapping("/list")
    public ResponseEntity<List<Train>> getTrainList(@RequestParam("source") String source,
            @RequestParam("destination") String destination) {
            List<Train> trainList = irctcService.findTrainsByRoute(source,destination);
            
            if (trainList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(trainList); // No trains found
            }
            return ResponseEntity.ok(trainList);     
    } 
    
    @PostMapping("/bookedPassengers")
    public ResponseEntity<String> receiveBookings(@RequestBody List<Book> passengers) {
    	
    	 for (Book passenger : passengers) {
    	        String pnr = irctcService.generatePNR(); // Generate PNR
    	        passenger.setPnr(pnr); // Set PNR in the passenger object
    	    }
    	 
    	irctcService.saveAllPassengers(passengers);
        Long trainId = passengers.get(0).getTrainId();
        Train train = irctcService.findTrainById(trainId); 
      
        if(train!=null)
        {
       	 int bookedseat = passengers.size();
       	 int updatedAvailableSeats  = train.getAvailableSeats() - bookedseat;
     	 train.setAvailableSeats(updatedAvailableSeats);
     	 irctcService.saveTrain(train);
      }
        return ResponseEntity.ok("Passengers have been successfully saved in the external service.");
    }
}

