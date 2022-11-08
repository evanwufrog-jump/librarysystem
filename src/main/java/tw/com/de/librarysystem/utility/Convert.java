package tw.com.de.librarysystem.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class Convert {
	@SuppressWarnings("unchecked")
	public static <D>D toDto(Object entity, Object dto) {
		ModelMapper modelMapper = new ModelMapper();
		return (D) modelMapper.map(entity, dto.getClass());
	}
	
	// 未測試
	public static List<Object> toDtoList(List<Object> entity, Object dto) {
		@SuppressWarnings("unused")
		ModelMapper modelMapper = new ModelMapper();
		return entity.stream().map(ee -> toDto(entity, dto)).collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	public static <E>E toEntity(Object dto, Object entity){
		ModelMapper modelMapper = new ModelMapper();
		return (E) modelMapper.map(dto, entity.getClass());		
	};

}
