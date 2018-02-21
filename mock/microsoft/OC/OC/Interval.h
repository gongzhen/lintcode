//
//  Interval.h
//  LC
//
//  Created by ULS on 2/16/18.
//  Copyright © 2018 ULS. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Interval : NSObject

@property(assign)NSInteger start;
@property(assign)NSInteger end;

- (instancetype)initWith:(NSInteger)s e:(NSInteger)e;

@end
