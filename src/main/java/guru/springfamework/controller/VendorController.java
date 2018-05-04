package guru.springfamework.controller;

import guru.springfamework.dto.VendorDTO;
import guru.springfamework.dto.VendorListDTO;
import guru.springfamework.service.VendorService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "Perform CRUD Operations on Vendor Resource")
public class VendorController {
    public static final String BASE_URL = "/vendor";

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/vendor")
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/vendor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    @PostMapping("/vendor")
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createVendor(vendorDTO);
    }

    @PutMapping("/vendor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.updateVendor(vendorDTO, id);
    }

    @PatchMapping("/vendor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.patchVendor(vendorDTO, id);
    }

    @DeleteMapping("/vendor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendorById(id);
    }

}
