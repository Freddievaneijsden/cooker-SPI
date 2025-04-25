import com.example.cooker.Cooker;
import com.example.provider.DutchCooking;
import com.example.provider.SwedishCooking;
import com.example.provider.ThaiCooking;

module com.example.provider {
    requires com.example.cooker;
    provides Cooker with DutchCooking, SwedishCooking, ThaiCooking;
}