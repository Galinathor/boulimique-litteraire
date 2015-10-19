(function(){
    angular.module('boulimiqueLitteraire').factory('RecipeCommentFactory', ['$http', function ($http) {

        var urlBase = '/api/recipeComments';
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

        factory.save = function (recipeComment) {
            return $http.post(urlBase, recipeComment).
                then(function(response) {
                    return response.data;
                }
            );
        }

        factory.update = function (recipeComment) {
            return $http.put(urlBase + '/' + recipeComment.id, recipeComment).
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