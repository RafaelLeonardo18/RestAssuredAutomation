package api;

/**************************************************************************************************
* Descrição: interface que define quais requisições HTTP serão utilizadas na automação
* Autor: Rafael Leonardo de Lima
* Data de criação: 16/11/2021
* *************************************************************************************************/

public interface ApiVerbose {

    void GET();
    void POST();
    void PUT();
    void PATCH();
    void DELETE();

}