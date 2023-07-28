package google;

import java.util.*;

public class Leetcode_2115 {
    List<String> created = new ArrayList<>();
    public static void main(String[] args) {
        Leetcode_2115 obj = new Leetcode_2115();


        String [] recipes = {"bread","sandwich","burger"};
        List<List<String>>  ingredients =  new ArrayList<>();
        List<String> subList1 = new ArrayList<>();
        subList1.add("yeast");
        subList1.add("flour");

        List<String> subList2 = new ArrayList<>();
        subList2.add("bread");
        subList2.add("meat");

        List<String> subList3 = new ArrayList<>();
        subList3.add("sandwich");
        subList3.add("meat");
        subList3.add("bread");

        ingredients.add(subList1);
        ingredients.add(subList2);
        ingredients.add(subList3);

        String []  supplies = {"yeast","flour","meat"};
        List<String> ans = obj.findAllRecipes(recipes, ingredients, supplies);
        System.out.println(ans);
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> recipesList = Arrays.asList(recipes);
        List<String> suppliesList = Arrays.asList(supplies);
        for(int i = 0; i < recipesList.size(); i++){
            createRecipes(recipesList.get(i), i, ingredients, suppliesList, recipesList);
        }

        return created;
    }

    boolean createRecipes(String recipe, int index, List<List<String>> ingredients,  List<String> supplies, List<String> recipesList){

        if(created.contains(recipe)) return true;

        List<String> ingredients_ = ingredients.get(index);

        Map<String, Integer> ingredientsNotInSuppliesMap = new LinkedHashMap<>();
        for(int i=0; i < ingredients_.size(); i++){
            if(!supplies.contains(ingredients_.get(i))){
                ingredientsNotInSuppliesMap.put(ingredients_.get(i), recipesList.indexOf(ingredients_.get(i)));
            }
        }
        if(ingredientsNotInSuppliesMap.isEmpty()){
            created.add(recipe);
            return true;
        }else{


            boolean allPresent = true;
            for(Map.Entry<String, Integer> entry: ingredientsNotInSuppliesMap.entrySet()){
                if(created.contains(entry.getKey())){
                    created.add(recipe);
                    return true;
                }

                if(!recipesList.contains(entry.getKey())){
                    allPresent = false;
                    break;
                }
            }
            if(allPresent == false){
                return false;
            }else{
                List<Boolean> booleanList = new ArrayList<>();
                ingredientsNotInSuppliesMap.forEach((key, value)->{
                    boolean isCreated = createRecipes(key, value, ingredients,  supplies, recipesList);
                    booleanList.add(isCreated);
                });

                if(booleanList.contains(false)){
                    return false;
                }else{
                    created.add(recipe);
                }
            }
        }

        return false;
    }

}
