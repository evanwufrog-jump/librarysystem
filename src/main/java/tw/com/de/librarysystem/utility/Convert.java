package tw.com.de.librarysystem.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Convert {
//	private static final ModelMapper modelMapper;
//	static {
//        modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//	}
//	static <D, T>D map(final T entity, Class<D> dto) {
//		return ModelMapper.map(entity, dto);
//	}
	
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
//BeanUtils.copyProperties(entity, modelMapper);
