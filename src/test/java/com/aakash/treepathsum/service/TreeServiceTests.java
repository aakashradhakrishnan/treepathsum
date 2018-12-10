package com.aakash.treepathsum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class TreeServiceTests {

    @InjectMocks
    TreeService treeService;

    @Test
    public void testSimpleTreeInput(){
        String inputTree = "1,2,null,null,3,4,null,null,5";
        String expectedResult = "9";

        String actualResult = treeService.calculateLongestPath(inputTree);
        assertEquals(expectedResult, actualResult);
    }
}
