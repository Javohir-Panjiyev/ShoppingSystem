package uz.master.warehouse.services.product;

import org.springframework.stereotype.Service;
import uz.master.warehouse.dto.product.ProductCreateDto;
import uz.master.warehouse.dto.product.ProductDto;
import uz.master.warehouse.dto.product.ProductUpdateDto;
import uz.master.warehouse.dto.responce.DataDto;
import uz.master.warehouse.entity.product.Product;
import uz.master.warehouse.mapper.product.ProductMapper;
import uz.master.warehouse.repository.product.ProductRepository;
import uz.master.warehouse.services.AbstractService;
import uz.master.warehouse.services.GenericCrudService;
import uz.master.warehouse.validator.project.ProductValidator;

import java.util.List;

@Service
public class ProductService extends AbstractService<ProductRepository, ProductMapper, ProductValidator> implements GenericCrudService<Product, ProductDto, ProductCreateDto, ProductUpdateDto,Long> {
    public ProductService(ProductRepository repository,
                          ProductMapper mapper,
                          ProductValidator validator) {
        super(repository, mapper, validator);
    }


    @Override
    public DataDto<Long> create(ProductCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public DataDto<Long> update(ProductUpdateDto updateDto) {
        return null;
    }

    @Override
    public DataDto<List<ProductDto>> getAll() {
        return null;
    }

    @Override
    public DataDto<ProductDto> get(Long id) {
        return null;
    }
}
