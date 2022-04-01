package uz.master.warehouse.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.master.warehouse.controller.base.AbstractController;
import uz.master.warehouse.dto.clientBar.ClientBarCreateDto;
import uz.master.warehouse.dto.clientBar.ClientBarDto;
import uz.master.warehouse.dto.clientBar.ClientBarUpdateDto;
import uz.master.warehouse.dto.responce.DataDto;
import uz.master.warehouse.services.clientBar.ClientBarService;

import java.util.List;

@RestController
@RequestMapping("client/*")
@RequiredArgsConstructor
public class ClientBarController extends AbstractController {

    private final ClientBarService service;

    @PostMapping(value =PATH +  "/create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody ClientBarCreateDto createDto){
        return new ResponseEntity<>(service.create(createDto), HttpStatus.OK);
    }

    @GetMapping(value = PATH + "/delete/{id}")
    public ResponseEntity<DataDto<Void>> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @PostMapping(value =PATH +  "/update")
    public ResponseEntity<DataDto<Long>> update(@RequestBody ClientBarUpdateDto createDto){
        return new ResponseEntity<>(service.update(createDto), HttpStatus.OK);
    }

    @GetMapping(value = PATH + "/get-all")
    public ResponseEntity<DataDto<List<ClientBarDto>>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = PATH + "/get/{id}")
    public ResponseEntity<DataDto<ClientBarDto>> get(@PathVariable Long id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

}
