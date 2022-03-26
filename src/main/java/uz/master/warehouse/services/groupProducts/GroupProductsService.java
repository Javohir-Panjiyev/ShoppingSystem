package uz.master.warehouse.services.groupProducts;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.master.warehouse.dto.groupProducts.GroupProductsCreateDto;
import uz.master.warehouse.dto.groupProducts.GroupProductsDto;
import uz.master.warehouse.dto.groupProducts.GroupProductsUpdateDto;
import uz.master.warehouse.dto.responce.DataDto;
import uz.master.warehouse.entity.product.GroupProducts;
import uz.master.warehouse.mapper.groupProducts.GroupProductsMapper;
import uz.master.warehouse.repository.groupProducts.GroupProductsRepository;
import uz.master.warehouse.services.AbstractService;
import uz.master.warehouse.services.GenericCrudService;
import uz.master.warehouse.validator.project.GroupProductsValidator;

import java.util.List;

@Service
public class GroupProductsService extends AbstractService<GroupProductsRepository, GroupProductsMapper, GroupProductsValidator>
        implements GenericCrudService<
        GroupProducts,
        GroupProductsDto,
        GroupProductsCreateDto,
        GroupProductsUpdateDto,
        Long> {

    public GroupProductsService(GroupProductsRepository repository, GroupProductsMapper mapper, GroupProductsValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public DataDto<Long> create(GroupProductsCreateDto createDto) {
        GroupProducts groupProducts = mapper.fromCreateDto(createDto);
        groupProducts.setCompanyId(createDto.getCompanyId());
        groupProducts.setDate(createDto.getDate());
        GroupProducts save = repository.save(groupProducts);
        return new DataDto<>(save.getId());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public DataDto<Long> update(GroupProductsUpdateDto updateDto) {
        GroupProducts groupProducts = mapper.fromUpdateDto(updateDto);
        groupProducts.setCompanyId(updateDto.getCompanyId());
        groupProducts.setDate(updateDto.getDate());
        GroupProducts save = repository.save(groupProducts);
        return new DataDto<>(save.getId());

    }

    @Override
    public DataDto<List<GroupProductsDto>> getAll() {
        List<GroupProducts> list = repository.findAll();
        return new DataDto<>(mapper.toDto(list));
    }

    @Override
    public DataDto<GroupProductsDto> get(Long id) {
        GroupProducts groupProducts = repository.findById(id).orElseThrow(() -> {
            throw new UsernameNotFoundException("Not found");
        });
        return new DataDto<>(mapper.toDto(groupProducts));
    }
}