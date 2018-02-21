//
//  UndirectedGraphNode.m
//  LC
//
//  Created by ULS on 2/17/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import "UndirectedGraphNode.h"

@interface UndirectedGraphNode()

@end

@implementation UndirectedGraphNode

- (instancetype)initWith:(NSInteger)x {
    if(self = [super init]) {
        _label = x;
        _neighbors = [NSMutableArray array];
    }
    return self;
}
@end
