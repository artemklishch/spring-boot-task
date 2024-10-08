package org.example.intro.mapper;

import org.example.intro.config.MapperConfig;
import org.example.intro.dto.cart.ShoppingCartDto;
import org.example.intro.model.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class, uses = {CartItemMapper.class})
public interface CartMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(target = "cartItems", source = "cartItems")
    ShoppingCartDto toCartDto(ShoppingCart shoppingCart);
}
