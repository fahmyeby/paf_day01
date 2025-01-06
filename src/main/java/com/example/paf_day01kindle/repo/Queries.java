package com.example.paf_day01kindle.repo;

public class Queries {
    public static final String SEARCH_BY_AUTHOR = """
            select * from kindle where author like ? limit ?
            """;
    
    public static final String SEARCH_BY_ASIN = """
            select * from kindle where asin = ?
            """;

    public static final String SEARCH_LIMIT = """
            select * from kindle limit ?
            """;
}
