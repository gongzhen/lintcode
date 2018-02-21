//
//  NSMutableArray+Queue.m
//  LC
//
//  Created by ULS on 2/12/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import "NSMutableArray+Queue.h"

@implementation NSMutableArray (Queue)

- (void)offer:(id)obj {
    if(obj == NULL) {
        return;
    }
    [self addObject:obj];
}

- (id)poll {
    if(self.count == 0) {
        return nil;
    }
    
    id ret = [self objectAtIndex:0];
    if(ret != nil) {
        [self removeObjectAtIndex:0];
    }
    return ret;
}

- (id)peek {
    if(self.count == 0) {
        return nil;
    }
    
    id ret = [self objectAtIndex:0];
    if(ret != nil) {
        return ret;
    }
    return nil;
}

@end
