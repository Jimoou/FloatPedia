package github.jimoou.floatsimulator.service;

import github.jimoou.floatsimulator.dto.FloatResponse;
import github.jimoou.floatsimulator.model.FloatRequest;

public interface FloatOperationService {
    FloatResponse floatResponse(FloatRequest floatRequest);
    String floatToBinary(float value);
    float binaryToFloat(String binary);
    float calculateResult(FloatRequest floatRequest);
    long calculateOperationSpeed(FloatRequest floatRequest);
    long calculateMemoryUsage();
}
