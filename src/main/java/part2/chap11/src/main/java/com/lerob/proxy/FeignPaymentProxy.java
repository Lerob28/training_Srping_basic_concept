package part2.chap11.src.main.java.com.lerob.proxy;


import com.lerob.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
    name = "payment",
    url = "${name.service.url}"
)
public interface FeignPaymentProxy {

    @PostMapping("/payment")
    Payment createPayment(
        @RequestHeader String requestId,
        @RequestBody Payment payment
    );

}
