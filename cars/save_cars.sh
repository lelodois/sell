curl --location --request POST 'http://localhost:8080/cars' \
     --header 'Content-Type: application/json' \
     --data '{"type": "Ronda", "model": "Civit"}' \
     --next \
     --location --request POST 'http://localhost:8080/cars' \
     --header 'Content-Type: application/json' \
     --data '{"type": "Toyota", "model": "Corolla"}' \
     --next \
     --location --request POST 'http://localhost:8080/cars' \
     --header 'Content-Type: application/json' \
     --data '{"type": "Fiat", "model": "Uno"}' \
     --next \
     --location --request POST 'http://localhost:8080/cars' \
     --header 'Content-Type: application/json' \
     --data '{"type": "Chevrolet", "model": "Onix"}' \
     --next \
     --location --request PUT 'http://localhost:8080/cars/1' \
     --header 'Content-Type: application/json' \
     --data '{"type": "Honda", "model": "Civic"}' \
     --next \
     --location --request GET 'http://localhost:8080/cars'