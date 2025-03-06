package com.co.fashion.application.mapper;

import com.co.fashion.application.dto.request.AddressRequest;
import com.co.fashion.application.dto.response.AddressResponse;
import com.co.fashion.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between Address entities and DTOs.
 * This interface uses MapStruct for automatic implementation generation.
 * 
 * @componentModel spring - Indicates that the generated implementation should be a Spring bean.
 * 
 * Methods:
 * - toEntity(AddressRequest dto): Converts a AddressRequest DTO to a Address entity.
 * - toDto(Address address): Converts a Address entity to a AddressResponse DTO.
 * - toDtoList(List<Address> address): Converts a list of Address entities to a list of AddressResponse DTOs.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    /**
     * Converts a AddressRequest DTO to a Address entity.
     *
     * @param dto the AddressRequest DTO
     * @return the converted Address entity
     */
    Address toEntity(AddressRequest dto);

    /**
     * Converts a Address entity to a AddressResponse DTO.
     *
     * @param address the Address entity
     * @return the converted AddressResponse DTO
     */
    AddressResponse toDto(Address address);

    /**
     * Converts a list of Address entities to a list of AddressResponse DTOs.
     *
     * @param address the list of Address entities
     * @return the converted list of AddressResponse DTOs
     */
    List<AddressResponse> toDtoList(List<Address> address);
}
