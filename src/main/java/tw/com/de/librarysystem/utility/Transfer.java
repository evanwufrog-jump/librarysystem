package tw.com.de.librarysystem.utility;

import org.modelmapper.ModelMapper;

public interface Transfer {

	@SuppressWarnings("unchecked")
	public static <D>D toDto(Object entity, Object dto) {
		ModelMapper modelMapper = new ModelMapper();
		return (D) modelMapper.map(entity, dto.getClass());
	}
	
	@SuppressWarnings("unchecked")
	public static <E>E toEntity(Object dto, Object entity){
		ModelMapper modelMapper = new ModelMapper();
		return (E) modelMapper.map(dto, entity.getClass());		
	};

}
