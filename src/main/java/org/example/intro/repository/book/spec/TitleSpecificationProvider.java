package org.example.intro.repository.book.spec;

import java.util.Arrays;
import org.example.intro.model.Book;
import org.example.intro.repository.book.BookSpecificationBuilder;
import org.example.intro.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return BookSpecificationBuilder.TITLE;
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> Arrays.stream(params)
                .map(title -> criteriaBuilder.like(
                        criteriaBuilder.upper(root.get(BookSpecificationBuilder.TITLE)),
                        "%" + title.toUpperCase() + "%"
                ))
                .reduce(criteriaBuilder::or)
                .orElse(null);
    }
}
