package com.files.PayementService.Services;

import java.util.ArrayList;
import java.util.List;

 import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
 
import com.files.PayementService.dto.StripeRespone;
import com.files.PayementService.external.BookingResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
 import com.stripe.param.checkout.SessionCreateParams; 
@Service
public class StripeService {
     
    
    @Value("${stripe.secretKey}")
    private String secretKey;
    
    public StripeRespone checkoutProduct(long userId, List<BookingResponse> bookings) {
        Stripe.apiKey = secretKey; // Set your Stripe secret key here

        try {
            // Create a list to hold all line items for the Stripe session
            List<SessionCreateParams.LineItem> lineItems = new ArrayList<SessionCreateParams.LineItem>();

            for (BookingResponse booking : bookings) {
                // Extract necessary details from each booking
                String productName = booking.getName(); // Assuming Booking has an event name
                String currency = "INR"; // Default currency (can be dynamic)
                Long amount = booking.getPrice(); // Assuming price is in cents
                long quantity = booking.getNoOfTickets(); // Assuming quantity exists in Booking

                // Create ProductData
                SessionCreateParams.LineItem.PriceData.ProductData productData = 
                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(productName)
                        .build();

                // Create PriceData
                SessionCreateParams.LineItem.PriceData priceData = 
                    SessionCreateParams.LineItem.PriceData.builder()
                        .setCurrency(currency)
                        .setUnitAmount(amount)
                        .setProductData(productData)
                        .build();

                // Create LineItem
                SessionCreateParams.LineItem lineItem = 
                    SessionCreateParams.LineItem.builder()
                        .setQuantity(quantity)
                        .setPriceData(priceData)
                        .build();

                // Add LineItem to the list
                lineItems.add(lineItem);
            }

            // Build the session creation parameters
            SessionCreateParams.Builder paramsBuilder = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://127.0.0.1:5500/Payement-Service/src/main/java/com/files/PayementService/ResponsePages/success.html")
                .setCancelUrl("http://127.0.0.1:5500/Payement-Service/src/main/java/com/files/PayementService/ResponsePages/failure.html");

            // Add all line items to the session
            for (SessionCreateParams.LineItem lineItem : lineItems) {
                paramsBuilder.addLineItem(lineItem);
            }

            // Create Stripe session
            Session session = Session.create(paramsBuilder.build());

            // Return the response
            return StripeRespone.builder()
                .status("Success")
                .message("Payment session created")
                .sessionId(session.getId())
                .sessionUrl(session.getUrl())
                .build();
        } catch (StripeException e) {
            throw new RuntimeException("Failed to create Stripe session: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred: " + e.getMessage(), e);
        }
    }

   }
