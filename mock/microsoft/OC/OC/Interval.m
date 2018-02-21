//
//  Interval.m
//  LC
//
//  Created by ULS on 2/16/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import "Interval.h"

@implementation Interval

- (instancetype)init {
    if(self = [super init]) {
        _start = 0;
        _end = 0;
    }
    return self;
}

- (instancetype)initWith:(NSInteger)s e:(NSInteger)e {
    if(self = [super init]) {
        _start = s;
        _end = e;
    }
    return self;
}

@end
