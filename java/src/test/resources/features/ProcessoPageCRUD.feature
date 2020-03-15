@runCrudProcessos
Feature: Processos page CRUD

  Background:
    Given the user is in the Agapito Software testing page

    Scenario: Add a new processo with success
      And the user clicks in the Processos menu option
      And the user clicks in the Novo Processo button
      And the user fills the value "1" to the "processo_vara" field in the Processo page
      And the user fills the value "123" to the "processo_numero_processo" field in the Processo page
      And the user fills the value "Guarda" to the "processo_natureza" field in the Processo page
      And the user fills the value "Parte A x Parte B" to the "processo_partes" field in the Processo page
      And the user fills the value "14/03/2020" to the "processo_data_entrada" field in the Processo page
      And the user fills the value "Agendado" to the "processo_status" field in the Processo page
      And the user selects the option "Sim" int the Arbitramento field
      And the user selects the option "Não" int the "processo_urgente" field
      When the user clicks in the "btn-save" in the Processo page
      Then the user should see the "Processo foi criado com sucesso." message in the Mostrar Processo page

  Scenario Outline: Add a new processo and see new processo from the main menu
    And the user clicks in the Processos menu option
    And the user clicks in the Novo Processo button
    And the user fills the value "<vara_value>" to the "processo_vara" field in the Processo page
    And the user fills the value "<numero_processo_value>" to the "processo_numero_processo" field in the Processo page
    And the user fills the value "<natureza_value>" to the "processo_natureza" field in the Processo page
    And the user fills the value "<partes_value>" to the "processo_partes" field in the Processo page
    And the user fills the value "<data_entrada_value>" to the "processo_data_entrada" field in the Processo page
    And the user fills the value "<status_value>" to the "processo_status" field in the Processo page
    And the user selects the option "<arbitramento_value>" int the Arbitramento field
    And the user selects the option "<urgente_value>" int the "processo_urgente" field
    And the user clicks in the "btn-save" in the Processo page
    And the user should see the "Processo foi criado com sucesso." message in the Mostrar Processo page
    And the user is in the Agapito Software testing page
    And the user clicks in the Processos menu option
    When the user clicks in the button "btn-show" of the processo
    Then the user should see the value "<vara_value>" message in the "vara" field
    And the user should see the value "<numero_processo_value>" message in the "numero" field
    And the user should see the value "<natureza_value>" message in the "natureza" field
    And the user should see the value "<partes_value>" message in the "partes" field

    Examples:
      |vara_value|numero_processo_value|natureza_value|partes_value   |data_entrada_value|status_value|arbitramento_value|urgente_value|
      |1         |123                  |Guarda        |Jano x Jana    |12-12-2019        |Agendado    |Sim               |Não          |
      |2         |312                  |Danos Morais  |Jair x Luis    |11-11-2019        |Agendado    |Não               |Sim          |
      |3         |666                  |Trabalhista   |Jorge x JBC    |10-10-2019        |Agendado    |Não               |Não          |
      |4         |999                  |Vale Tudo     |Silva x avlis  |09-09-2019        |Agendado    |Sim               |Sim          |

  Scenario Outline: Add a new processo and update processo from the main menu
    And the user clicks in the Processos menu option
    And the user clicks in the Novo Processo button
    And the user fills the value "<vara_value>" to the "processo_vara" field in the Processo page
    And the user fills the value "<numero_processo_value>" to the "processo_numero_processo" field in the Processo page
    And the user fills the value "<natureza_value>" to the "processo_natureza" field in the Processo page
    And the user fills the value "<partes_value>" to the "processo_partes" field in the Processo page
    And the user fills the value "<data_entrada_value>" to the "processo_data_entrada" field in the Processo page
    And the user fills the value "<status_value>" to the "processo_status" field in the Processo page
    And the user selects the option "<arbitramento_value>" int the Arbitramento field
    And the user selects the option "<urgente_value>" int the "processo_urgente" field
    And the user clicks in the "btn-save" in the Processo page
    And the user should see the "Processo foi criado com sucesso." message in the Mostrar Processo page
    And the user is in the Agapito Software testing page
    And the user clicks in the Processos menu option
    And the user clicks in the button "btn-edit" of the processo
    And the user fills the value "<new_vara_value>" to the "processo_vara" field in the Processo page
    When the user clicks in the "btn-save" in the Processo page
    And the user should see the "Processo atualizado com sucesso." message in the Mostrar Processo page
    Then the user should see the value "<new_vara_value>" message in the "vara" field

    Examples:
      |vara_value|numero_processo_value|natureza_value|partes_value   |data_entrada_value|status_value|arbitramento_value|urgente_value|new_vara_value|
      |1         |123                  |Guarda        |Jano x Jana    |12-12-2019        |Agendado    |Sim               |Não          |11            |
      |2         |312                  |Danos Morais  |Jair x Luis    |11-11-2019        |Agendado    |Não               |Sim          |12            |

  Scenario Outline: Add a new processo and delete processo from the main menu
    And the user clicks in the Processos menu option
    And the user clicks in the Novo Processo button
    And the user fills the value "<vara_value>" to the "processo_vara" field in the Processo page
    And the user fills the value "<numero_processo_value>" to the "processo_numero_processo" field in the Processo page
    And the user fills the value "<natureza_value>" to the "processo_natureza" field in the Processo page
    And the user fills the value "<partes_value>" to the "processo_partes" field in the Processo page
    And the user fills the value "<data_entrada_value>" to the "processo_data_entrada" field in the Processo page
    And the user fills the value "<status_value>" to the "processo_status" field in the Processo page
    And the user selects the option "<arbitramento_value>" int the Arbitramento field
    And the user selects the option "<urgente_value>" int the "processo_urgente" field
    And the user clicks in the "btn-save" in the Processo page
    And the user should see the "Processo foi criado com sucesso." message in the Mostrar Processo page
    And the user is in the Agapito Software testing page
    And the user clicks in the Processos menu option
    And the user clicks in the button "btn-delete" of the processo
    When the user clicks in the OK option of the confirmation window
    Then the user should not see the value processo in the processos page

    Examples:
      |vara_value|numero_processo_value|natureza_value|partes_value   |data_entrada_value|status_value|arbitramento_value|urgente_value|
      |1         |123                  |Guarda        |Arlo x Arla    |12-12-2019        |Agendado    |Sim               |Não          |
      |2         |312                  |Danos Morais  |Lala x Lolo    |11-11-2019        |Agendado    |Não               |Sim          |