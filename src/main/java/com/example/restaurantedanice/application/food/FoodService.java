package com.example.restaurantedanice.application.food;

import com.example.restaurantedanice.infra.food.Food;
import com.example.restaurantedanice.infra.food.FoodRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FoodService {

    @Autowired
    private FoodRepository repository;

    //C.R.U.D

    public FoodDetailDTO cadastrarComida(FoodCreateDTO dados){

        var comida = new Food(dados);
        repository.save(comida);
        var dadosDetalhamentoComida = new FoodDetailDTO(comida);
        return dadosDetalhamentoComida;

    }

    public Page<FoodListDTO> listarComidas(Pageable pageable){

        var page = repository.findAllByAtivoTrue(pageable).map(FoodListDTO::new);
        return page;

    }

    public FoodDetailDTO detalharComida(Long id){

        var comida = repository.getReferenceById(id);
        var dadosDetalhamentoComida = new FoodDetailDTO(comida);
        return dadosDetalhamentoComida;

    }

    public void atualizarComida(FoodUpdateDTO dados){

        var comida = repository.getReferenceById(dados.id());
        comida.atualizarDados(dados);

    }

    public void excluirComida(Long id) throws EntityNotFoundException{
        var comida = repository.getReferenceById(id);
        if (comida.equals(null)){
            throw new EntityNotFoundException();
        }
        comida.setAtivo(false);
    }



}
