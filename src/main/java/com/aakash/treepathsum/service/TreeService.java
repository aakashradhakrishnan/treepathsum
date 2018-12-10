package com.aakash.treepathsum.service;

import com.aakash.treepathsum.model.TreeNode;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("treeService")
public class TreeService {
    static int max_height = 0;
    public String calculateLongestPath(String tree){
        max_height = 0;
        TreeNode root = deserializeInput(tree);

        Map<Integer, Integer> pathSum = new HashMap<>();
        longestPath(pathSum, root, 0, 0);
        return pathSum.get(max_height).toString();

    }

    public TreeNode deserializeInput(String s){
        String[] inputTree = s.split(",");
        List<String> inputList = new LinkedList<String>(Arrays.asList(inputTree));
        return deserializeHelper(inputList);
    }

    public TreeNode deserializeHelper(List<String> list){
        if(list.isEmpty())
            return null;

        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);

        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);

        return root;
    }

    public void longestPath(Map<Integer, Integer> result, TreeNode root, int sum, int height){
        if(root == null)
            return;

        if(root.left==null && root.right==null){
            sum += root.val;
            if(!result.containsKey(height-1)){
                result.put(height-1, sum);
            }
            else{
                if(result.get(height-1)<sum){
                    result.put(height-1, sum);
                }
            }
            max_height = Math.max(height-1,max_height);
            return;
        }

        longestPath(result, root.left, sum+root.val, height+1);
        longestPath(result, root.right, sum+root.val, height+1);
    }
}
