# Api-rest - Consulta de Cep

Com o objetivo de fazer uma API para consulta de cep

# Requisitos
PostgreSQL via Docker
Hibernate
java11
Spring Boot


# Instalação

[Docker](https://www.docker.com/)

## Para rodar o Docker use o comando
```shell
    $ docker-compose up --build
```

# Metodos

## GET CEP
### Descrição:
    Obter um único CEP
    Tipo: GET
    URL: {contexto}/cep/​{cep}
    Exemplo: http://localhost:8080/cep/01001000

#### Retorno 
```json
            {
                "cep": "01001-010",
                "logradouro": "Rua Filipe de Oliveira",
                "complemento": "",
                "bairro": "Sé",
                "cidade": {
                    "ibge": "3550308",
                    "uf": "SP",
                    "localidade": "São Paulo"
                }
            }
```

## Ação
    Caso o CEP não exista, consultar o site http://viacep.com.br/​ e realizar o cadastro do cep e da cidade.



## GET CEPs
### Descrição:
    Obter a lista de CEPs de uma cidade
    Tipo: GET
    URL: {contexto}/ceps
    Parâmetros: ibge (obrigatório) e uf
    Exemplo: http://localhost:8080/ceps?ibge=3550308&uf=SP

#### Retorno
```json
[
    {
        "cep": "01001-010",
        "logradouro": "Rua Filipe de Oliveira",
        "complemento": "",
        "bairro": "Sé",
        "cidade": {
            "ibge": "3550308",
            "uf": "SP",
            "localidade": "São Paulo"
        }
    },
    {
        "cep": "01001-000",
        "logradouro": "Praça da Sé",
        "complemento": "lado ímpar",
        "bairro": "Sé",
        "cidade": {
            "ibge": "3550308",
            "uf": "SP",
            "localidade": "São Paulo"
        }
    }
]
```


##### Para auxilio da Documentação foi o usado o 'Swagger' 
    Depois que a api estiver rodando pode acessar o link baixo
        
[Swagger da api](http://localhost:8080/swagger-ui.html)



#### OBS.: Todas as informações foram tiradas do Documento do 'Teste Dev back - Wine'. 
