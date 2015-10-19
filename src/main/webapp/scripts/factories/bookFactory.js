(function(){
    angular.module('boulimiqueLitteraire').factory('BookFactory', ['$http', function ($http) {

        var urlBase = '/api/books';
        var factory = {};

        factory.getAll = function () {
            return $http.get(urlBase)
            .then(function (results){
                return results.data;
            });
        };

        factory.getById = function (id) {
            return $http.get(urlBase + '/' + id).
                then(function (result){
                    return result.data;
                }
            );
        }

        factory.save = function (book) {
            return $http.post(urlBase, book).
                then(function(response) {
                    return response.data;
                }
            );
        }

        factory.update = function (book) {
            return $http.put(urlBase + '/' + book.id, book).
                then(function(response) {
                    return response.data;
                }
            );
        }

        factory.remove = function (id) {
            return $http.delete(urlBase + '/' + id);
        }

        return factory;
    }]);
}());