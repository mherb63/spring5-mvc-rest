package guru.springfamework.service;

import guru.springfamework.Exception.ResourceNotFoundException;
import guru.springfamework.domain.Vendor;
import guru.springfamework.dto.VendorDTO;
import guru.springfamework.dto.VendorListDTO;
import guru.springfamework.mapper.VendorMapper;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService{
    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public VendorListDTO getAllVendors() {
        List<VendorDTO> vdtoList = vendorRepository.findAll()
                .stream()
                .map(vendor -> {return getVendorDTO(vendor);})
                .collect(Collectors.toList());
        return new VendorListDTO(vdtoList);
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(vendor -> {return getVendorDTO(vendor);})
                .orElseThrow(() -> new ResourceNotFoundException("No vendor found with id: " + id));
    }

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {
        Vendor v = vendorRepository.save(vendorMapper.vendorDTOToVendor(vendorDTO));
        return getVendorDTO(v);
    }

    @Override
    public VendorDTO updateVendor(VendorDTO vendorDTO, Long id) {
        return vendorRepository.findById(id).map(vendor -> {
            vendor.setName(vendorDTO.getName());
            return getVendorDTO(vendorRepository.save(vendor));
        }).orElseThrow(() -> new ResourceNotFoundException("No vendor found with id: " + id));
    }

    @Override
    public VendorDTO patchVendor(VendorDTO vendorDTO, Long id) {
        return null;
    }

    @Override
    public void deleteVendorById(Long id) {

    }

    private VendorDTO getVendorDTO(Vendor vendor) {
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
        vendorDTO.setVendorUrl("/vendor/" + vendor.getId());
        return vendorDTO;
    }
}
