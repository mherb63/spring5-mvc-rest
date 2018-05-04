package guru.springfamework.service;

import guru.springfamework.dto.VendorDTO;
import guru.springfamework.dto.VendorListDTO;

public interface VendorService {
    VendorListDTO getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO createVendor(VendorDTO vendorDTO);

    VendorDTO updateVendor(VendorDTO vendorDTO, Long id);

    VendorDTO patchVendor(VendorDTO vendorDTO, Long id);

    void deleteVendorById(Long id);
}
