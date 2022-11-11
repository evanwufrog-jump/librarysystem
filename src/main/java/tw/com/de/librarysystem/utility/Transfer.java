package tw.com.de.librarysystem.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public interface Transfer<E, D> {

	@SuppressWarnings("unchecked")
	public static <D>D toDto(Object entity, D dto) {
		ModelMapper modelMapper = new ModelMapper();
//		ModelMapper modelMapper = new ModelMapper();
		return (D) modelMapper.map(entity, dto.getClass());
	}
	
	// 測試失敗(全部屬性都是null)
	public default List<D> toDtoList(List<E> entitys, D dto) {
		return entitys
		.stream().map(e -> (D) toDto(entitys, dto))
		.collect(Collectors.toList());
		
//		.map(entity -> (D) modelMapper.map(entity, dto.getClass()))
//		.collect(Collectors.toList());
		
//		return  reservationRepository.findAll()
//				.stream()
//				.map(eo -> (ReservationDto) Convert.toDto(eo, new ReservationDto()))
//				.collect(Collectors.toList());
		
	}
	
	@SuppressWarnings("unchecked")
	public static <E>E toEntity(Object dto, E entity){
		ModelMapper modelMapper = new ModelMapper();
		return (E) modelMapper.map(dto, entity.getClass());		
	};

}
