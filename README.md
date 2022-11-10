# Task Manager API

Ez a RestAPI arra szolgál, hogy kapcsolatot létesítsen a MySql és a front-end között és kezelje a feladatokat.

Maga az API OpenAPI-t használ ahhoz, hogy létrehozzon egy beépített dokumentációt (swagger-ui), ahol akár tesztelni is lehet a különböző lekérdezéseket!

## Mire képes / Hogyan működik ?

Első sorban az api használatához, szükséges egy MySql szerver és egy adatbázis. (Maga az adatbázis bármilyen néven létre jöhet, viszont táblát nem kell bele létre hozni, a program autómatikusan megcsinálja és beállítja)

Ezután az [application.properties](TaskManagerApi/src/main/resources/application.properties)-nevű fájlt kell megnyitni és az alábbi sorokat módosítani:

```
spring.datasource.url=jdbc:mysql://localhost:3306/DBNAME?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
```

A DBNAME helyére kell kerüljön az adatbázis neve, a USERNAME helyére a belépési név a PASSWORD helyére a jelszó.

Tesztelés közben előfordult olyan eset, hogy pár sorral ami szerepel az említett application.properties-ben gondja akad.
Ha ezzel kapcsolatban fellép valami probléma, akkor az alábbi sorokat kell/kellhet módosítani!

```
spring.datasource.url=jdbc:mysql://localhost:3306/DBNAME?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
```

Ennél a végére oda kell írni egy kiegészítést:

```
&allowPublicKeyRetrieval=true
```

Illetve, ha maga a MySql tábla nem tud létre jönni (a kapcsolat már létre jött és a gond a tábla létre hozása közben keletkezett), akkor az alábbi sort törölni kell:

```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```

Ha a MySql sikeresen beállításra került, az API-nak innentől kezdve működnie kellene és nincs további tehendő!

Amennyiben le akarja ellenőrizni, hogy rendesen fut-e a program, az alábbi linken keresztül lehet eléírni a beépített Swagger-UI-t!
```
localhost:8080/swagger-ui/index.html
```

Amennyiben a szerver nem ezen a porton (8080) vagy nem a saját gépünkön fut, akkor a localhost-ot ki kell cserélni az IP címre és a portot a megadottra. (alapértelmezetten a 8080-as portot használja az API)

## Lekérdezések

Amennyiben az API már fut, akkor 2 féle képpen lehet ellenőrizni / végrehalytani a lekérdezéseket.
Azt fontos megemlítenem, hogy az API minden esetben application/json fájl formátumban válaszol!

### Swagger-UI ( 1. mód )

Az API ahogy említettem Swagger-UI-t használ a dokumentációra, így ezen keresztül akár tesztelni is lehet.

### Külső programok ( Pl.: Postman )

Jelenleg az api 4 különböző dolgot kezel (GET, POST, PUT, DELETE).

Ezekhez az elérési utak az alábbiak:

```
localhost:8080/api/tasks/all          ( GET )    - Lekérdezi az adatbázisban található összes adatot!
localhost:8080/api/tasks/add          ( POST )   - Ennek szükséges megadni body-ban az új rekord értéketi (lásd swagger-ui dokumentációban)
localhost:8080/api/tasks/delete/{id}  ( DELETE ) - Itt a header-ben kell megadni az {id} helyére a törlendő rekord ID-ét!
localhost:8080/api/tasks/update/{id}  ( PUT )    - Itt szintén a headerben kell megadni az id-t, viszont ez vár egy body részt is a módosítandó adatokkal!
```
