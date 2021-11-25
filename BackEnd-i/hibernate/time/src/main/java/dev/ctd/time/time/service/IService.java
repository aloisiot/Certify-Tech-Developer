package dev.ctd.time.time.service;

import java.util.List;
import java.util.Map;

public interface IService <T> {

    Map cadastrar(Map m);

    List<Map> buscarTodos();

    Map buscarPorNome(String nome);

    List<Map> buscarCujoNomeContem(String subString);

    Map objectToMap(T t);

    List<Map> objectListToMapList(List<T> tList);

}
