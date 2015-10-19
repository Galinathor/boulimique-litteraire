(function(){
    angular.module('boulimiqueLitteraire').factory('RecipeFactory', ['$http', function ($http) {

        var urlBase = '/api/recipes';
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

        factory.save = function (recipe) {
            return $http.post(urlBase, recipe).
                then(function(response) {
                    return response.data;
                }
            );
        }

        factory.update = function (recipe) {
            return $http.put(urlBase + '/' + recipe.id, recipe).
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