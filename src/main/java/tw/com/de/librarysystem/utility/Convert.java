package tw.com.de.librarysystem.utility;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Convert {
	private static final ModelMapper modelMapper;
	static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
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
	public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
    }
	
	public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }
	
	public static <S, D> D mapEntity(final S outClass, D entity) {
        modelMapper.map(outClass, entity);
        return entity;
    }
}
//BeanUtils.copyProperties(entity, modelMapper);
